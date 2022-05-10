require "json"

package = JSON.parse(File.read(File.join(__dir__, "package.json")))

Pod::Spec.new do |s|
  s.name         = "react-native-rakuten-rewark"
  s.version      = package["version"]
  s.summary      = package["description"]
  s.homepage     = package["homepage"]
  s.license      = package["license"]
  s.authors      = package["author"]

  s.platforms    = { :ios => "11.0" }
  s.source       = { :git => "https://github.com/wtanuw/react-native-rakuten-rewark.git", :tag => "#{s.version}" }

  s.ios.deployment_target = '9.0'
  s.swift_version = '4.2'

  # https://github.com/prscX/react-native-photo-editor
  # https://github.com/ivpusic/react-native-image-crop-picker
  # https://github.com/henninghall/react-native-date-picker
  # https://github.com/TimOliver/TOCropViewController
  s.source_files = 
  # "ios/**/*.{h,m,mm}", 
  "ios/toast/*.{h,m,mm}",
  "ios/rakuten/*.{h,m,mm}",
  # s.exclude_files = 
  # "ios/Photo Editor/AppDelegate.swift",
  # 'ios/TOCropViewController/include/**/*.h'
  # s.resources = "ios/Photo Editor/*.{png,jpeg,jpg,storyboard,xib,ttf}"

  s.dependency "React-Core"
  s.dependency 'RakutenRewardSDK'

  # s.dependency 'React-Core'
  s.dependency 'React-RCTImage'
  # s.dependency 'TOCropViewController'
end