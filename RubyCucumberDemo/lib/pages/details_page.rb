class DetailsPage < SitePrism::Page
	# set_url_matcher /\/product\/\d+.html?\d+,\d+/
	set_url "/product/{/product_number}.html"

	elements :networks, '#pro-skus .pro-sku-text ol a'
	elements :colors, '#pro-skus ol li a'
	element :quantity, '#pro-quantity'
	element :add, '.button-add-cart'
	section :success_popup, SuccessPopup, '#cart-tips'

	def select_package table
		table.hashes.each do |row|
			if row['选择制式']
				expected_network = row['选择制式']
				networks.each do |network|
					if network.text == expected_network
						network.click
						break
					end
				end
			end
			if row['颜色']
				expected_color = row['颜色']
				colors.each do |c|
					if c['title'] == expected_color
						c.click
						break
					end
				end
			end
			quantity.set row['数量'] if row['数量']
		end
		add.click
	end

	def move_to destination
		success_popup.walking.click if destination=='继续逛逛'
		success_popup.go_cart.click if destination=='去结算'
	end
end
