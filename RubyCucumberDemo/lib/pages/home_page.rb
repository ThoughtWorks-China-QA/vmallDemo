class HomePage < SitePrism::Page
	set_url '/'

	elements :navs, '.naver ul li a'
	sections :all_product, AllProducts, '.category-info'

	def select title, child
		all_product.each do |a|
			if a.title.text == title
				a.sub_products.each do |sp|
					if sp.sub_title.text == child
						sp.root_element.click
						break
					end
				end
				break
			end
		end
	end
end
