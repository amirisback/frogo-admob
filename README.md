![ScreenShoot Apps](docs/image/ss_banner.png?raw=true)

## About This Project
[![](https://jitpack.io/v/amirisback/frogo-admob.svg?style=flat-square)](https://jitpack.io/#amirisback/frogo-admob-helper)
[![Medium Badge](https://img.shields.io/badge/-faisalamircs-black?style=flat-square&logo=Medium&logoColor=white&link=https://medium.com/@fiqryq)](https://medium.com/@faisalamircs/dapatkan-penghasilan-dari-aplikasi-androidmu-di-play-store-dengan-admob-helper-f21288de5071)
- Helper for activating admob
- Example Source Code For Call Method Show Admob
- Calling method on Inheritance Class
- Implement all Admob Version

## ScreenShot Apps
| Banner and Interstitial | RecyclerView with Banner | Rewarded Apps |
|:-----------------------:|:------------------------:|:-------------:|
|<span align="center"><img width="200px" height="360px" src="docs/image/ss_image_1.png"></span> | <span align="center"><img width="200px" height="360px" src="docs/image/ss_image_2.png"></span> | <span align="center"><img width="200px" height="360px" src="docs/image/ss_image_3.png"></span> |

## Version Release

    $version_release = 3.0.0

What's New??

    * Refactoring Code *
    * Enhance Performance *
    * Fixing Bug *
    * Remove unused code *
    * Update documentation *
    * Update build.gradle *
    * Update sample code *
    * Add: Rewarded Ad *
    * Add: Rewarded Interstital Ad *

## How To Use / Implement This Project
### Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
### Step 2. Add the dependency

	dependencies {
	        // library google ads
            implementation 'com.google.android.gms:play-services-ads:${latest_version}'

            // library frogo-admob-helper
	        implementation 'com.github.amirisback:frogo-admob:3.0.0'
	}
	
### Step 3. Adding meta-data on AndroidManifest.xml

	<manifest>
        <application>
            <!-- Sample AdMob App ID: ca-app-pub-3940256099942544~3347511713 -->
            <meta-data
                android:name="com.google.android.gms.ads.APPLICATION_ID"
                android:value="ca-app-pub-xxxxxxxxxxxxxxxx~yyyyyyyyyy"/>
        </application>
    </manifest>
	
### Step 4. Extend on your activity

    class <YourActivity> : FrogoAdmobActivity() {
    
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setupAdmob()
        }
    
        private fun setupAdmob(){
            setBasePublisherID(<Your_Publisher_ID>)
            setBaseBannerAdUnitID(<Your_Banner_Unit_ID>)
            setBaseInterstialAdUnitID(<Your_Interstitial_Unit_ID>)
            setBaseRewardedAdUnitID(<Your_Rewarded_Unit_ID>)
            setBaseRewardedInterstitialAdUnitID(<Your_Rewarded_Interstitial_Unit_ID>)
            setBaseAdmob()
        }	
    }

### Step 5. Main function for calling Ads

    // Show Banner Ads
    fun setupShowAdsBanner(<Your_Banner_Layout_ID>)

    // Show Interstitial Ads
    fun setupShowAdsInterstitial()

    // Show Rewarded Ads
    fun setupShowAdsRewarded(callback: IFrogoAdmob.UserEarned)

    // Show Rewarded Interstitial Ads
    fun setupShowAdsRewardedInterstitial(callback: IFrogoAdmob.UserEarned)

### Step 6. Now enjoy your earning by monetizing apps
    
    Get Ready For Publish Apps

## Test Ads From Google

    // Declaration admob id for debug
    def debugAdmobPublisherId = "ca-app-pub-3940256099942544~3347511713"
    def debugAdmobBanner = "ca-app-pub-3940256099942544/6300978111"
    def debugAdmobInterstitial = "ca-app-pub-3940256099942544/1033173712"
    def debugAdmobInterstitialVideo = "ca-app-pub-3940256099942544/8691691433"
    def debugAdmobRewarded = "ca-app-pub-3940256099942544/5224354917"
    def debugAdmobRewardedInterstitial = "ca-app-pub-3940256099942544/5354046379"
    def debugAdmobNativeAdvanced = "ca-app-pub-3940256099942544/2247696110"
    def debugAdmobNativeAdvancedVideo = "ca-app-pub-3940256099942544/1044960115"

## Still Confusing For Using This Project???
- Just Clone This Project
- branch : master 
- branch : before-using-library <br> -- Pick Your Choice!! --

## Colaborator
Very open to anyone, I'll write your name under this, please contribute by sending an email to me

- Mail To faisalamircs@gmail.com
- Subject : Github _ [Github-Username-Account] _ [Language] _ [Repository-Name]
- Example : Github_amirisback_kotlin_admob-helper-implementation

Name Of Contribute
- Muhammad Faisal Amir
- Waiting List
- Waiting List

Waiting for your contribute

## Source
- Google Sample Code [Click Here](https://github.com/googleads/googleads-mobile-android-examples)
- Test Ads [Click Here](https://developers.google.com/admob/android/test-ads)
- For Get Started [Click Here](https://developers.google.com/admob/android/quick-start)

## Attention !!!
Please enjoy and don't forget fork and give a star
- Don't Forget Follow My Github Account
