# Run Flutter Tests With Appium Java — TestMu AI (Formerly LambdaTest)

<img width="2350" height="1368" alt="Image" src="https://github.com/user-attachments/assets/7e7d3c93-bd86-4c43-a365-5007729542b7" />

<p align="center">
  <a href="https://www.testmu.ai/blog/?utm_source=github&utm_medium=repo&utm_campaign=appium-flutter-java-sample" target="_bank">Blog</a>
  &nbsp; &#8901; &nbsp;
  <a href="https://www.testmu.ai/support/docs/?utm_source=github&utm_medium=repo&utm_campaign=appium-flutter-java-sample" target="_bank">Docs</a>
  &nbsp; &#8901; &nbsp;
  <a href="https://www.testmu.ai/learning-hub/?utm_source=github&utm_medium=repo&utm_campaign=appium-flutter-java-sample" target="_bank">Learning Hub</a>
  &nbsp; &#8901; &nbsp;
  <a href="https://www.testmu.ai/newsletter/?utm_source=github&utm_medium=repo&utm_campaign=appium-flutter-java-sample" target="_bank">Newsletter</a>
  &nbsp; &#8901; &nbsp;
  <a href="https://www.testmu.ai/certifications/?utm_source=github&utm_medium=repo&utm_campaign=appium-flutter-java-sample" target="_bank">Certifications</a>
  &nbsp; &#8901; &nbsp;
  <a href="https://www.youtube.com/@TestMuAI" target="_bank">YouTube</a>
</p>
&emsp;
&emsp;

In this 'Appium Flutter Java Automation' repo, we have covered the nuances of automating Flutter application testing using the following Appium drivers:
- [Appium Flutter Driver](https://github.com/appium/appium-flutter-driver)
- [Appium Flutter Integration Driver](https://github.com/AppiumTestDistribution/appium-flutter-integration-driver/)

The testing is performed on Real Device Cloud infrastructure provided by [TestMu AI](https://www.testmu.ai/)

## Steps for test execution

**Step 1**

Fetch the TestMu AI Credentials from the [TestMu AI Profile Section](https://accounts.lambdatest.com/security/username-accesskey) section. Export the environment variables *LT_USERNAME* and *LT_ACCESS_KEY* by triggering the following commands on the terminal:

For macOS:

```bash
export LT_USERNAME=LT_USERNAME
export LT_ACCESS_KEY=LT_ACCESS_KEY
```

For Linux:

```bash
export LT_USERNAME=LT_USERNAME
export LT_ACCESS_KEY=LT_ACCESS_KEY
```

For Windows:

```bash
set LT_USERNAME=LT_USERNAME
set LT_ACCESS_KEY=LT_ACCESS_KEY
```

Alternatively, update the TestMu AI Credentials - [LT_USERNAME](https://github.com/LambdaTest/flutter-appium-java/blob/main/Makefile#L19) and [LT_ACCESS_KEY](https://github.com/LambdaTest/flutter-appium-java/blob/main/Makefile#L20) in Makefile.

**Step 2**

For testing, we have used the open-source [Provider Shopper Flutter sample app](https://github.com/flutter/samples/tree/main/provider_shopper). The app is built for testing with the Flutter Driver and Flutter Integration Driver respectively.

You can download the Apps from the following locations:

- [Provider Shopper Flutter sample app - Flutter Driver](https://pub-b8556f54909d4c829fb7c6761d7284fe.r2.dev/shoppers-app-appium-flutter-driver.apk)
- [Provider Shopper Flutter sample app - Flutter Integration Driver](https://pub-b8556f54909d4c829fb7c6761d7284fe.r2.dev/shoppers-app-appium-flutter-integration-driver.apk)

The app needs to be uploaded to the TestMu AI cloud storage. For this, run the following commands on tge terminal for uploading the app:

```bash
curl -u "LT_USERNAME:LT_ACCESS_KEY" \
  -X POST "https://manual-api.lambdatest.com/app/upload/realDevice" \
  -F "url=https://pub-b8556f54909d4c829fb7c6761d7284fe.r2.dev/shoppers-app-appium-flutter-driver.apk" \
  -F "name=shoppers-app-appium-flutter-driver.apk" \
  -F "custom_id=sampleName" \
  -F "storage=url" \
  -F "visibility=individual"
```

```bash
curl -u "LT_USERNAME:LT_ACCESS_KEY" \
  -X POST "https://manual-api.lambdatest.com/app/upload/realDevice" \
  -F "url=https://pub-b8556f54909d4c829fb7c6761d7284fe.r2.dev/shoppers-app-appium-flutter-integration-driver.apk" \
  -F "name=shoppers-app-appium-flutter-integration-driver.apk" \
  -F "custom_id=sampleName" \
  -F "storage=url" \
  -F "visibility=individual"
```

If the command execution is successful, you would see a APP ID in the command output:

<img width="1488" height="249" alt="Image" src="https://github.com/user-attachments/assets/7799c47a-509f-42d1-a015-feaa3192f584" />

You would also see the respective app in the [App Live App Dashboard](https://applive.lambdatest.com/app)

<img width="1503" height="827" alt="Image" src="https://github.com/user-attachments/assets/a6101d69-62f4-46b9-b795-c6ecf3c97f08" />

Now that both the apps are uploaded to the TestMu AI cloud storage, retrieve the App ID by clicking on the *Settings* button next to uploaded app:

<img width="1488" height="692" alt="Image" src="https://github.com/user-attachments/assets/07b054f2-0da2-4dc2-a55a-272dac547941" />

Next, update the App ID in the test files:

- [Flutter Driver Test Code](https://github.com/LambdaTest/flutter-appium-java/blob/main/src/main/java/AndroidApp_Flutter.java#L18)
- [Flutter Integration Driver Test Code](https://github.com/LambdaTest/flutter-appium-java/blob/main/src/main/java/AndroidApp_Flutter_Integration.java#L17)

**Step 3**

Run the *make clean* command on the terminal to clean the temporary files

```bash
make clean
```

Run the *make build* command on the terminal to build the automation project

```bash
make build
```

<img width="1480" height="583" alt="Image" src="https://github.com/user-attachments/assets/dedc788c-d14c-4c34-a08f-3651e4a9a2c2" />
<br/><br/>

**Step 4 - Automation with Appium Flutter Integration Driver**

Trigger the command ```make flutter-integration-driver-test``` to test Flutter app on the TestMu AI cloud grid using the Appium Flutter Integration Driver.

<img width="1485" height="591" alt="Image" src="https://github.com/user-attachments/assets/dca99c36-e78e-46d8-adff-f69686540f6a" />

<img width="1039" height="408" alt="Image" src="https://github.com/user-attachments/assets/ca2ffc0b-71cc-4295-b924-b259214cf509" />

Navigate to the [TestMu AI Automation Dashboard](https://automation.lambdatest.com/) to check the status of the test execution.

<img width="1495" height="827" alt="Image" src="https://github.com/user-attachments/assets/3c407a14-e25b-4410-8f17-a0883f193b21" />
<br/><br/>

**Step 5 - Automation with Appium Flutter Driver**

Trigger the command ```make flutter-driver-test``` to test Flutter app on the TestMu AI cloud grid using the Appium Flutter Driver.

<img width="1488" height="491" alt="Image" src="https://github.com/user-attachments/assets/929ffe9a-a1b9-4d25-ba5b-67f3bd4e56c9" />

<img width="1132" height="454" alt="Image" src="https://github.com/user-attachments/assets/f0faa4ef-67e7-4a6a-9fbb-ef477052fb83" />

Navigate to the [TestMu AI Automation Dashboard](https://automation.lambdatest.com/) to check the status of the test execution.

<img width="1495" height="827" alt="Image" src="https://github.com/user-attachments/assets/5ad05468-1189-4216-9f57-a392cc655a8e" />
<br/>

## Tutorials 📙

Check out our latest tutorials on Appium Flutter Java testing 👇

* [Automating Flutter Apps Using Appium Flutter Driver With Java](https://www.testmu.ai/blog/automating-flutter-apps-using-appium-flutter-driver/?utm_source=github&utm_medium=repo&utm_campaign=appium-flutter-java-sample)
* [Appium Flutter Integration Driver Guide](https://www.testmu.ai/support/docs/appium-flutter-integration/?utm_source=github&utm_medium=repo&utm_campaign=appium-flutter-java-sample)
* [A Complete Guide To Flutter Testing](https://www.testmu.ai/blog/flutter-testing/?utm_source=github&utm_medium=repo&utm_campaign=appium-flutter-java-sample)

## Documentation & Resources :books:

      
Visit the following links to learn more about TestMu AI's features, setup and tutorials around test automation, mobile app testing, responsive testing, and manual testing.

* [TestMu AI Documentation](https://www.testmu.ai/support/docs/?utm_source=github&utm_medium=repo&utm_campaign=appium-flutter-java-sample)
* [TestMu AI Blog](https://www.testmu.ai/blog/?utm_source=github&utm_medium=repo&utm_campaign=appium-flutter-java-sample)
* [TestMu AI Learning Hub](https://www.testmu.ai/learning-hub/?utm_source=github&utm_medium=repo&utm_campaign=appium-flutter-java-sample)    

## TestMu AI Community :busts_in_silhouette:

The [TestMu AI Community](https://community.testmu.ai/?utm_source=github&utm_medium=repo&utm_campaign=appium-flutter-java-sample) allows people to interact with tech enthusiasts. Connect, ask questions, and learn from tech-savvy people. Discuss best practises in web development, testing, and DevOps with professionals from across the globe 🌎

## What's New At TestMu AI ❓

To stay updated with the latest features and product add-ons, visit [Changelog](https://changelog.testmu.ai/)

## 🚀 LambdaTest is Now TestMu AI

👋 Welcome to TestMu AI, the next evolution of LambdaTest. As of January 2026, [LambdaTest is Now TestMu AI](https://www.testmuai.com/lambdatest-is-now-testmuai/) - we have evolved from a cross-browser testing cloud into a unified, AI-native quality engineering platform designed for the modern DevOps era.

Whether you have been part of the LambdaTest community for years or are just discovering TestMu AI, our mission remains the same: to help you ship faster with high-scale test execution, autonomous testing, and deep quality analytics.

### 🔄 Our Rebrand Journey

In 2017, we introduced LambdaTest with a clear mission: to become the world's most trusted cloud testing platform. We built a scalable, high-performance test cloud that eliminated flakiness, improved developer feedback cycles, and accelerated release velocity for teams worldwide.

As LambdaTest grew, we expanded the platform into Test Intelligence, Visual Regression Testing, Accessibility Testing, API Testing, and Performance Testing, covering the entire testing lifecycle. These capabilities enabled teams to test any stack, on any technology, at enterprise scale.

Over time, we rebuilt the architecture to be AI-native from the ground up. What began as LambdaTest's high-performance testing cloud has now evolved into TestMu AI, an AI-native, multi-agent platform redefining modern quality engineering.

We chose the name TestMu AI to reflect our shift towards intelligent, autonomous testing. While our identity has changed, our core technology and commitment to the testing community stay the same.

👉 Find [LambdaTest's New Home](https://www.testmuai.com/).

### 🔭 Explore TestMu AI

The same infrastructure LambdaTest customers relied on, now delivered through autonomous AI agents.

- [KaneAI](https://www.testmuai.com/kane-ai/)
- [Agent-to-Agent Testing](https://www.testmuai.com/agent-to-agent-testing/)
- [HyperExecute](https://www.testmuai.com/hyperexecute/)
- [Real Device Cloud](https://www.testmuai.com/real-device-cloud/)
- [Pricing](https://www.testmuai.com/pricing/)
- [Documentation](https://www.testmuai.com/support/docs/)