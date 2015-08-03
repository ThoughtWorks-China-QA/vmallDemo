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
  Capybara::Selenium::Driver.new(app)
end

Capybara.app_host = 'http://www.vmall.com'
Capybara.default_driver = :selenium

Capybara.current_session.driver.browser.manage.window.maximize
