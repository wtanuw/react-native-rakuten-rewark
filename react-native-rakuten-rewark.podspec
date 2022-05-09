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
  "ios/Photo Editor/*.{swift}",
  "ios/croppicker/*.{h,m,mm}", 
  "ios/TOCropViewController/**/*.{h,m}",
  "ios/RNDatePicker/*.{h,m}",
  s.exclude_files = 
  "ios/Photo Editor/AppDelegate.swift",
  'ios/TOCropViewController/include/**/*.h'
  s.resources = "ios/Photo Editor/*.{png,jpeg,jpg,storyboard,xib,ttf}"

  s.dependency "React-Core"
  s.dependency 'RakutenRewardSDK'

  s.dependency 'iOSPhotoEditor'

  # s.dependency 'React-Core'
  s.dependency 'React-RCTImage'
  # s.dependency 'TOCropViewController'

  s.subspec 'QBImagePickerController' do |qb|
    qb.name             = "QBImagePickerController"
    qb.source_files     = "ios/QBImagePicker/QBImagePicker/*.{h,m}"
    qb.exclude_files    = "ios/QBImagePicker/QBImagePicker/QBImagePicker.h"
    qb.resource_bundles = { "QBImagePicker" => "ios/QBImagePicker/QBImagePicker/*.{lproj,storyboard}" }
    qb.requires_arc     = true
    qb.frameworks       = "Photos"
  end
end