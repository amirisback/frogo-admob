![ScreenShoot Apps](docs/image/ss_banner.png?raw=true)

# About This Project
[![](https://jitpack.io/v/amirisback/frogo-admob-helper.svg)](https://jitpack.io/#amirisback/frogo-admob-helper)
- Helper for activating admob
- Example Source Code For Call Method Show Admob
- Calling method on Inheritance Class
- Implement all Admob Version

# ScreenShot Apps
Banner and Interstitial	|	RecyclerView with Banner	|
:----------:|:-------------:|
<span align="center"><img width="200px" height="360px" src="docs/image/ss_image_1.png"></span> | <span align="center"><img width="200px" height="360px" src="docs/image/ss_image_2.png"></span> |

# Medium Link
https://medium.com/@faisalamircs/dapatkan-penghasilan-dari-aplikasi-androidmu-di-play-store-dengan-admob-helper-f21288de5071

# Version Release

    $version_release = 1.0.0

What's New??

    * Yes, Now Its Library *
    
# How To Use / Implement This Project
<h3>Step 1. Add the JitPack repository to your build file</h3>

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
<h3>Step 2. Add the dependency</h3>

	dependencies {
	        // library google ads
            implementation 'com.google.android.gms:play-services-ads:18.3.0'

            // library frogo-admob-helper
	        implementation 'com.github.amirisback:frogo-admob-helper:${version_release}'
	}
	
<h3>Step 3. Adding meta-data on AndroidManifest.xml</h3>

	<manifest>
        <application>
            <!-- Sample AdMob App ID: ca-app-pub-3940256099942544~3347511713 -->
            <meta-data
                android:name="com.google.android.gms.ads.APPLICATION_ID"
                android:value="ca-app-pub-xxxxxxxxxxxxxxxx~yyyyyyyyyy"/>
        </application>
    </manifest>
	
<h3>Step 4. Extend on your activity</h3>

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
            setBaseAdmob()
        }	
    }

<h3>Step 5. Main function for calling Ads</h3>
    
     fun setupShowAdsInterstitial()
     fun setupShowAdsBanner(<Your_Banner_Layout_ID>)

<h3>Step 6. Now enjoy your earning by monetizing apps</h3>
    
    Get Ready For Publish Apps

# Still Confusing For Using This Project???
- Just Clone This Project
- branch : master 
- branch : before-using-library <br> -- Pick Your Choice!! --

# Test Ads From Google 

    def debugAdmobPublisherId = "ca-app-pub-3940256099942544~3347511713"
    def debugAdmobBanner = "ca-app-pub-3940256099942544/6300978111"
    def debugAdmobInterstitial = "ca-app-pub-3940256099942544/1033173712"
    def debugAdmobInterstitialVideo = "ca-app-pub-3940256099942544/8691691433"
    def debugAdmobRewardedVideo = "ca-app-pub-3940256099942544/5224354917"
    def debugAdmobNativeAdvanced = "ca-app-pub-3940256099942544/2247696110"
    def debugAdmobNativeAdvancedVideo = "ca-app-pub-3940256099942544/1044960115"

# How To Use This Project (Depcrecated)
- Just Clone on Your Android Studio
- Learn this code project for inject to your project
- String test ads can found on build.gradle in folder app
- Change in release build variant on build.gradle with your admob id
- (Branch : Before Using Library)

# Result Of This Project
- All logic on AdmobHelper and BaseActivity
- All layout banner
- All string test ads
- Implement, interstitial and banner ads
- Other still progress

# Special From This Project
- Inheritance RecyclerViewAdapter (BaseViewAdapter, BasViewHolder, BaseListener)
- Inheritance AdmobActivity (BaseAdmobActivity, BaseAdmobRecyclerActivity)
- AdmobHelper.kt class for all function admob
- Example all layout for all banner ads size
- Certainly Clean Code

# Minus From This Project
- Comment code are too simple
- Only one thought is the creator of the project
- Creator of this project indeed need your help

# Colaborator
Very open to anyone, I'll write your name under this, please contribute by sending an email to me

- Mail To faisalamircs@gmail.com
- Subject : Github _ [Github-Username-Account] _ [Language] _ [Repository-Name]
- Example : Github_amirisback_kotlin_admob-helper-implementation

Name Of Contribute
- Muhammad Faisal Amir
- Waiting List
- Waiting List

Waiting for your contribute

# Source
- https://github.com/googleads/googleads-mobile-android-examples (Google Sample Code)
- https://developers.google.com/admob/android/test-ads (Test Ads)
- https://developers.google.com/admob/android/quick-start (For Get Started)

# Attention !!!
Please enjoy and don't forget fork and give a star
- Don't Forget Follow My Github Account