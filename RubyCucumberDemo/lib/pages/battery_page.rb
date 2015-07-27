class BatteryPage < SitePrism::Page
	set_url_matcher /\/list-\d+/

	sections :batteries, Batteries, '.pro-list ul li'

	def go_to_details name
		batteries.each do |b|
			if b.name.text == name
				b.name.click
				break
			end
		end
	end
end
