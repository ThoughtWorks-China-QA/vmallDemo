class ProductsInCart < SitePrism::Section
	element :name, '.sc-pro-item .tr-pro .p-name a'
	element :remove, '.sc-pro-item .tr-operate a'
	element :plus, '.sc-pro-item .icon-plus-3'
	element :minus, '.sc-pro-item .icon-minus-3'
end
