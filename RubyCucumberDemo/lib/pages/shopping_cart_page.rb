class ShoppingCartPage < SitePrism::Page
	set_url /\/cart\/cart.html\?t\=\/d+/

	element :check_all, '#checkAll-top'
	sections :products, ProductsInCart, 'div[id*="order-pro"]'
	element :are_you_sure_yes, '#ec_ui_confirm_yes'
	element :price, '#sc-cartInfo-totalPrice'
	element :checkout, '.button-go-checkout-2'

	def remove_product name
		products.each do |product|
			if product.name.text == name
				product.remove.click
				are_you_sure_yes.click
				break
			end
		end
	end

	def get_count_of_products
		products.length
	end

	def total_price
		price.text
	end

	def adjust_count arg1, count, name
		products.each do |product|
			if product.name.first.text == name
				if arg1=='多'
					temp = 0
					while temp<count.to_i do
						product.plus.click
						temp+=1
					end
				elsif arg1=='少'
					temp = count.to_i
					while temp>0 do
						product.minus.click
						temp-=1
					end
				end
				break
			end
		end
	end

	def move_to destination
		checkout.click if destination=='去结算'
	end
end
