package greenstyle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import greenstyle.config.UserPrincipal;
import greenstyle.dto.CreateProductDTO;
import greenstyle.dto.CreateReceiptDTO;
import greenstyle.dto.Message;
import greenstyle.dto.ResponseData;
import greenstyle.dto.ValueData;
import greenstyle.entity.Product;
import greenstyle.entity.Receipt;
import greenstyle.service.ProductService;
import greenstyle.service.ReceiptService;

@RestController
@RequestMapping("/api/v1/admin/receipt")
public class ReceiptController {

	@Autowired
	private ReceiptService receiptService;
	
	@GetMapping("/user")
	@PreAuthorize("hasAnyAuthority('ROLE_USER')")
	public ResponseData getAll() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = null;
		Integer id = null;
		if (principal instanceof UserDetails) {
		    UserPrincipal userPrincipal = (UserPrincipal) principal;
		    username = ((UserDetails) principal).getUsername();
		    id = ((UserPrincipal) principal).getUserId();
		}
		List<Receipt> list =  receiptService.getAll(id);
		ResponseData response = new ResponseData();
		response.setSuccess(true);
		ValueData valuesData  = new ValueData();
		valuesData.setMessage("");
		valuesData.setValues(list);
		response.setPayload(valuesData);
		response.setError(null);
		return response;
	}
	
	@PostMapping()
	@PreAuthorize("hasAnyAuthority('ROLE_USER')")
	public ResponseData create(@RequestBody CreateReceiptDTO data) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = null;
		Integer id = null;
		if (principal instanceof UserDetails) {
		    UserPrincipal userPrincipal = (UserPrincipal) principal;
		    username = ((UserDetails) principal).getUsername();
		    id = ((UserPrincipal) principal).getUserId();
		}
		receiptService.create(username,id,data);
		ResponseData response = new ResponseData();
		response.setSuccess(true);
		Message mes  = new Message();
		mes.setMessage("Dat hang thanh cong");
		response.setPayload(mes);
		response.setError(null);
		return response;
	}
}
