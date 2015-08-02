假如(/^:我选择"([^"]*)"中的"([^"]*)"$/) do |title, sub_title|
	App.homepage.load
	App.homepage.select title, sub_title
	step "转到新窗口"
end

假如(/^:我进入"([^"]*)"的主页面$/) do |title|
	App.battery_page.go_to_details title
	step "转到新窗口"
end
