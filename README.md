![ScreenShoot Apps](docs/image/ss_banner.png?raw=true)

## About This Project
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-frogo--admob-brightgreen.svg?style=flat-square)](https://android-arsenal.com/details/1/8251)
[![JitPack](https://jitpack.io/v/amirisback/frogo-admob.svg?style=flat-square)](https://jitpack.io/#amirisback/frogo-admob-helper)
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

    $version_release = 4.0.1

What's New??

    * Enhance Performance *
    * Refactoring Code *
    * Remove unused code *
    * Update documentation *
    * Update build.gradle *
    * Update sample code *

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
	        implementation 'com.github.amirisback:frogo-admob:4.0.1'
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
	
### Step 4. Setup Admob with Extend on your activity

    class <YourActivity> : FrogoAdmobActivity() {
    
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setupAdmob()
        }

        private fun setupAdmob(){
            setPublisher()
            setBanner()
            setInterstitial()
            setRewarded()
            setRewardedInterstitial()
        }

        private fun setPublisher() {
            setupAdsPublisher(getString(R.string.admob_publisher_id))
        }

        private fun setBanner() {
            setupAdsBanner(getString(R.string.admob_banner))
        }

        private fun setInterstitial() {
            setupAdsInterstitial(getString(R.string.admob_interstitial))
        }

        private fun setRewarded() {
            setupAdsRewarded(getString(R.string.admob_rewarded))
        }

        private fun setRewardedInterstitial() {
            setupAdsRewardedInterstitial(getString(R.string.admob_rewarded_interstitial))
        }

    }


### Step 5. Showing ads

    class <YourActivity> : FrogoAdmobActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setupAdmob()
            setupButtonClick()
        }

        ...
        ...
        ...

        private fun setupButtonClick() {

            binding.apply {

                btnInterstitial.setOnClickListener {
                    setupShowAdsInterstitial()
                }

                btnRewarded.setOnClickListener {
                    setupShowAdsRewarded(object : IFrogoAdmob.UserEarned {
                        override fun onUserEarnedReward(rewardItem: RewardItem) {
                            // TODO User Get Reward
                        }
                    })
                }

                btnRewardedInterstitial.setOnClickListener {
                    setupShowAdsRewardedInterstitial(object : IFrogoAdmob.UserEarned {
                        override fun onUserEarnedReward(rewardItem: RewardItem) {
                            // TODO User Get Reward
                        }
                    })
                }

                btnRecyclerView.setOnClickListener {
                    baseStartActivity<NewsActivity>()
                }

                btnRecyclerView2.setOnClickListener {
                    baseStartActivity<MovieActivity>()
                }

            }

        }

    }

## Allert

### Update

    >> on version 3.0.0
    - import com.frogobox.admob.core.FrogoRvConstant
    - import com.frogobox.admob.core.admob.FrogoAdmob
    - import com.frogobox.admob.core.admob.FrogoAdmobActivity
    - import com.frogobox.admob.core.FrogoAdmobViewHolder
    - import com.frogobox.admob.core.FrogoAdmobViewAdapter
    - import com.frogobox.admob.core.AdmobViewHolder

    >> on version 4.0.0
    - import com.frogobox.admob.core.FrogoRvConstant
    - import com.frogobox.admob.core.FrogoAdmob
    - import com.frogobox.admob.ui.FrogoAdmobActivity
    - import com.frogobox.admob.widget.FrogoAdmobViewHolder
    - import com.frogobox.admob.widget.FrogoAdmobViewAdapter
    - import com.frogobox.admob.widget.AdmobViewHolder

### Test Ads From Google

    // Declaration admob id for debug
    def debugAdmobPublisherId = "ca-app-pub-3940256099942544~3347511713"
    def debugAdmobBanner = "ca-app-pub-3940256099942544/6300978111"
    def debugAdmobInterstitial = "ca-app-pub-3940256099942544/1033173712"
    def debugAdmobInterstitialVideo = "ca-app-pub-3940256099942544/8691691433"
    def debugAdmobRewarded = "ca-app-pub-3940256099942544/5224354917"
    def debugAdmobRewardedInterstitial = "ca-app-pub-3940256099942544/5354046379"
    def debugAdmobNativeAdvanced = "ca-app-pub-3940256099942544/2247696110"
    def debugAdmobNativeAdvancedVideo = "ca-app-pub-3940256099942544/1044960115"

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

![ScreenShoot Apps](docs/image/mad_score.png?raw=true)