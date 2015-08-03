当(/^:转到"([^"]*)"$/) do |destination|
	App.details_page.move_to destination
end

假如(/^:我进入"([^"]*)"款产品的详细页面$/) do |number|
	App.details_page.load(product_number: number)
end

而且(/^:我选择以下套餐加入购物车:$/) do |table|
   App.details_page.select_package table
end
