# Rubygems and Bundler

# Gems
require 'capybara'
require 'capybara/cucumber'
require 'capybara/poltergeist'
require 'site_prism'
require 'pry'
require "require_all"

require_all 'lib'
require_all 'lib/sections'
require_all 'lib/pages'

Capybara.register_driver :selenium do |app|
  options = {
      browser: :firefox,
      desired_capabilities: {
	      "firefoxOptions" => {
	        "args" => %w{ window-size=1920,1280 }
	      }
	  }
  }
  Capybara::Selenium::Driver.new(app, options)
end

Capybara.app_host = 'http://www.vmall.com'
Capybara.default_driver = :selenium
