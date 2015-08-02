当(/^:转到"([^"]*)"$/) do |destination|
	App.details_page.move_to destination
end

假如(/^:我进入"([^"]*)"款产品的详细页面$/) do |number|
	App.details_page.load(product_number: number)
end
