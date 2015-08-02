假如(/^:我删除"([^"]*)"$/) do |product_name|
	App.shopping_cart_page.remove_product product_name
end

那么(/^:购物车中只有"([^"]*)"种商品$/) do |number|
	sleep 1
	expect(App.shopping_cart_page.get_count_of_products).to eq number.to_i
end

而且(/^:合计（不含运费）为"([^"]*)"元$/) do |money|
	expect(App.shopping_cart_page.total_price).to eq money
end

当(/^:我"([^"]*)"买"([^"]*)"台"([^"]*)"$/) do |arg1, count, name|
	App.shopping_cart_page.adjust_count arg1, count, name
end

当(/^:我选择购物车中的所有商品$/) do
	App.shopping_cart_page.select_all
end

当(/^:从购物车转"([^"]*)"$/) do |destination|
	App.shopping_cart_page.move_to destination
end
