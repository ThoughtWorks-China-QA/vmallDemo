假如 /转到新窗口/ do
	page.driver.browser.close
	page.driver.browser.switch_to.window(page.driver.window_handles.last)
end

假如(/^:我选择"([^"]*)"中的"([^"]*)"$/) do |title, sub_title|
	App.homepage.load
	App.homepage.select title, sub_title
	step "转到新窗口"
end

假如(/^:我进入"([^"]*)"的主页面$/) do |title|
	App.battery_page.go_to_details title
	step "转到新窗口"
end

那么(/^:我可以在页面上看到如下信息:$/) do |table|
	sleep 1
	table.hashes.each do |t|
		expect(page).to have_text(t['文字'])
	end
	sleep 1
end

而且(/^:我选择以下套餐加入购物车:$/) do |table|
	App.details_page.select_package table
end

当(/^:转到"([^"]*)"$/) do |destination|
	App.details_page.move_to destination
end

当(/^:从购物车转"([^"]*)"$/) do |destination|
	App.shopping_cart_page.move_to destination
end

假如(/^:我进入"([^"]*)"款产品的详细页面$/) do |number|
	App.details_page.load(product_number: number)
end

假如(/^:我删除"([^"]*)"$/) do |product_name|
	App.shopping_cart_page.remove_product product_name
end

那么(/^:购物车中只有"([^"]*)"种商品$/) do |number|
	expect(App.shopping_cart_page.get_count_of_products).to eq number.to_i
end

当(/^:我选择购物车中的所有商品$/) do
	App.shopping_cart_page.select_all
end

而且(/^:合计（不含运费）为"([^"]*)"元$/) do |money|
	expect(App.shopping_cart_page.total_price).to eq money
end

当(/^:我"([^"]*)"买"([^"]*)"台"([^"]*)"$/) do |arg1, count, name|
	App.shopping_cart_page.adjust_count arg1, count, name
end
