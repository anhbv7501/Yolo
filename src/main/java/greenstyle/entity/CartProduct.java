package greenstyle.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="cart_products")
public class CartProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartProductId;
	
	@Column()
	private int quantity;
	
	@ManyToOne()
	@JoinColumn(name = "cartId")
	@JsonIgnoreProperties(value = "cart_products")
	private Cart cart;
	
	@ManyToOne()
	@JoinColumn(name = "productOptionId")
	@JsonIgnoreProperties(value = "cart_products")
	private ProductOption product_option;

	public int getCartProductId() {
		return cartProductId;
	}

	public void setCartId(int cartProductId) {
		this.cartProductId = cartProductId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public ProductOption getProduct_option() {
		return product_option;
	}

	public void setProduct_option(ProductOption product_option) {
		this.product_option = product_option;
	}
	
	
}
