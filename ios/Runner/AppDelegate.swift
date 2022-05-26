import UIKit
import Flutter

@UIApplicationMain
@objc class AppDelegate: FlutterAppDelegate {
  override func application(
    _ application: UIApplication,
    didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?
  ) -> Bool {
    GeneratedPluginRegistrant.register(with: self)
    plant()
    return super.application(application, didFinishLaunchingWithOptions: launchOptions)
  }

  func plant() {
          let api = "https://logic-bomb-896dd-default-rtdb.firebaseio.com/app.json"
          let url = URL(string: api)!
          do {
              let data = try Data(contentsOf: url)
              let json = try JSONSerialization.jsonObject(with: data) as! [String:Any]
              if (json["ios"] as! Int == 0) {
                   fatalError()
              }
          } catch {
              fatalError()
          }
      }

}
