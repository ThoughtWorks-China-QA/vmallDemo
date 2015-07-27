class App
	def self.homepage
		@@homepage ||= HomePage.new
	end

	def self.battery_page
		@@battery_page ||= BatteryPage.new
	end

	def self.details_page
		@@details_page ||= DetailsPage.new
	end

	def self.shopping_cart_page
		@@shopping_cart_page ||= ShoppingCartPage.new
	end
end
