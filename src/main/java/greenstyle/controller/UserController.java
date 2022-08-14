package greenstyle.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import greenstyle.dto.ChangeStatusDTO;
import greenstyle.dto.CreateProductDTO;
import greenstyle.dto.DataDTO;
import greenstyle.dto.Message;
import greenstyle.dto.ResProduct;
import greenstyle.dto.ResUserDTO;
import greenstyle.dto.ResponseData;
import greenstyle.entity.Product;
import greenstyle.entity.User;
import greenstyle.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping()
	public ResponseData get(@RequestParam(name = "page",required = false) Integer page) {
		List<User> list =  userService.getAll();
		List<ResUserDTO> listU =  new ArrayList<ResUserDTO>();
		for(User u : list) {
			listU.add(new ResUserDTO(u));
		}
		ResponseData response = new ResponseData();
		response.setSuccess(true);
		DataDTO valuesData  = new DataDTO();
		valuesData.setData(listU);
		response.setPayload(valuesData);
		response.setError(null);
		return response;
	}
	
	@PutMapping("/change-status/{id}")
	public ResponseData changeStatus(@PathVariable(name="id") int id,@RequestBody ChangeStatusDTO data) {
		User user = this.userService.changeStatus(id, data);
		ResponseData response = new ResponseData();
		response.setSuccess(true);
		Message mess  = new Message();
		mess.setMessage("Đổi trạng thái người dùng thành công");
		response.setPayload(mess);
		response.setError(null);
		return response;
	}

	
}

