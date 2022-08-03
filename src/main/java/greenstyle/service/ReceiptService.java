package greenstyle.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import greenstyle.dto.CreateReceiptDTO;
import greenstyle.dto.ProductI;
import greenstyle.entity.Product;
import greenstyle.entity.ProductOption;
import greenstyle.entity.Receipt;
import greenstyle.entity.ReceiptProduct;
import greenstyle.entity.ReceiptProductOption;
import greenstyle.entity.User;
import greenstyle.repository.ProductOptionRepository;
import greenstyle.repository.ReceiptProductOptionRepository;
import greenstyle.repository.ReceiptProductRepository;
import greenstyle.repository.ReceiptRepository;
import greenstyle.repository.UserRepository;

@Component
public class ReceiptService {

	@Autowired
	private ReceiptRepository receiptRepo;
	@Autowired
	private ReceiptProductRepository receiptProductRepo;
	@Autowired
	private ReceiptProductOptionRepository receiptProductOptionRepo;
	@Autowired
	private ProductOptionRepository productOptionRepo;
	@Autowired
	private UserRepository userRepo;
	
	public List<Receipt> getAll(Integer id){
		return this.receiptRepo.findByUser(id);
	}
	
	public Receipt create(String username,Integer id,CreateReceiptDTO data) {
		System.out.print(username);

		double total_price = 0;
		for(ProductI product : data.getProducts()) {
			total_price += product.getPrice();
		}
		
		Receipt receipt = new Receipt();
		
		User user = new User();
		user.setUserId(id);
		System.out.print(user.getRole());
		receipt.setAddress(data.getAddress());
		receipt.setDescription(data.getDescription());
		receipt.setMethod(data.getMethod());
		receipt.setTotal_price(total_price);
		receipt.setUser(user);
		try {
			receipt = receiptRepo.saveAndFlush(receipt);
			for(ProductI product : data.getProducts()) {
				ReceiptProduct receiptProduct = new ReceiptProduct();
				List<ReceiptProductOption> receiptProductOptionData = new ArrayList<ReceiptProductOption>();
				receiptProduct.setReceipt(receipt);
				receiptProduct.setQuantity(product.getQuantity());
				receiptProduct.setUnit_price(product.getPrice());
				receiptProductRepo.save(receiptProduct);
				for(Integer productOptionId : product.getProductOptionId() ) {
					Optional<ProductOption> op = this.productOptionRepo.findById(productOptionId);
					if(op.isPresent()) {
						ReceiptProductOption receiptProductOption = new ReceiptProductOption();
						receiptProductOption.setProduct_option(op.get());
						receiptProductOption.setReceipt_product(receiptProduct);
						receiptProductOption.setQuantity(0);
						receiptProductOption = receiptProductOptionRepo.save(receiptProductOption);
						receiptProductOptionData.add(receiptProductOption);
					}
					ProductOption productOption = op.get();
					productOption.setNumber(productOption.getNumber() - product.getQuantity());
					productOptionRepo.save(productOption);
					
				}
			}
		
		}catch(Exception e){
			System.out.print(e);
		}
		return receipt;
		
	}
}
