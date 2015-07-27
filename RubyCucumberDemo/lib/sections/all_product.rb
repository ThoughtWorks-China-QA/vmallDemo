class AllProducts < SitePrism::Section
	element :title, 'h3 span'
	sections :sub_products, Product, 'a'
end
