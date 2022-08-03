package greenstyle.entity;

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
@Table(name="cart_product_options_product_option")
public class CartProductOption {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartProductOptionId;
	
	@ManyToOne()
	@JoinColumn(name = "cartId")
	@JsonIgnoreProperties(value = "cart_product_options")
	private Cart cart;
	
	@ManyToOne()
	@JoinColumn(name = "productOptionId")
	@JsonIgnoreProperties(value = "cart_product_options")
	private ProductOption product_option;

	public int getCartProductOptionId() {
		return cartProductOptionId;
	}

	public void setCartProductOptionId(int cartProductOptionId) {
		this.cartProductOptionId = cartProductOptionId;
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
