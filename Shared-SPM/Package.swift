// swift-tools-version:5.3
import PackageDescription

let package = Package(
    name: "Shared",
    platforms: [
        .iOS(.v14)
    ],
    products: [
        .library(
            name: "Shared",
            targets: ["Shared"]
        )
    ],
    targets: [
        .binaryTarget(
            name: "Shared",
            url: "https://github.com/ktlevell/ecommerce-shared-ui/releases/download/1.0/Shared.xcframework.zip",
            checksum: "bbef3b661ec5f3f2b13ebb267d66a66da8066ad05802dd35e01d993decee0337"
        )
    ]
)