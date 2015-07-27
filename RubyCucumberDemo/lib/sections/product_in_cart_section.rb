class ProductsInCart < SitePrism::Section
	element :name, '.tr-pro .p-name a'
	element :remove, '.tr-operate a'
	element :plus, '.icon-plus-3'
	element :minus, '.icon-minus-3'
end
