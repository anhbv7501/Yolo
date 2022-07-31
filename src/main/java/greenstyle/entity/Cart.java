package greenstyle.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="carts")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;
	
	@Column()
	private String note;
	
	@OneToMany(mappedBy = "cart")
	@JsonIgnoreProperties(value = "cart")
	private List<CartProduct> cart_products;
	
	@OneToOne()
	@JoinColumn(name="userId")
	private User user;

	@OneToMany(mappedBy = "cart")
	@JsonIgnoreProperties(value = "cart")
	private List<CartProductOption> cart_product_options;
	
	
	
	public List<CartProductOption> getCart_product_options() {
		return cart_product_options;
	}

	public void setCart_product_options(List<CartProductOption> cart_product_options) {
		this.cart_product_options = cart_product_options;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public List<CartProduct> getCart_products() {
		return cart_products;
	}

	public void setCart_products(List<CartProduct> cart_products) {
		this.cart_products = cart_products;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
