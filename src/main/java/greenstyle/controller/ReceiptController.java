package greenstyle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import greenstyle.entity.Product;
import greenstyle.entity.Receipt;
import greenstyle.service.ProductService;
import greenstyle.service.ReceiptService;

@RestController
@RequestMapping("/api/receipt")
public class ReceiptController {

	@Autowired
	private ReceiptService receiptService;
	
	@GetMapping("/show")
	public List<Receipt> getAll() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = null;
		Integer id = null;
		if (principal instanceof UserDetails) {
		    UserPrincipal userPrincipal = (UserPrincipal) principal;
		    username = ((UserDetails) principal).getUsername();
		    id = ((UserPrincipal) principal).getUserId();
		}
		return receiptService.getAll(id);
	}
	
	@PostMapping("/create")
	public Receipt create(@RequestBody CreateReceiptDTO data) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = null;
		Integer id = null;
		if (principal instanceof UserDetails) {
		    UserPrincipal userPrincipal = (UserPrincipal) principal;
		    username = ((UserDetails) principal).getUsername();
		    id = ((UserPrincipal) principal).getUserId();
		}
		return receiptService.create(username,id,data);
	}
}
