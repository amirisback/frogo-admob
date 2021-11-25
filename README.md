![ScreenShoot Apps](docs/image/ss_banner.png?raw=true)

## About This Project
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-frogo--admob-brightgreen.svg?style=flat-square)](https://android-arsenal.com/details/1/8251)
[![JitPack](https://jitpack.io/v/amirisback/frogo-admob.svg?style=flat-square)](https://jitpack.io/#amirisback/frogo-admob-helper)
[![Medium Badge](https://img.shields.io/badge/-faisalamircs-black?style=flat-square&logo=Medium&logoColor=white&link=https://medium.com/@faisalamircs)](https://medium.com/@faisalamircs/dapatkan-penghasilan-dari-aplikasi-androidmu-di-play-store-dengan-admob-helper-f21288de5071)
- Available on Google Dev Library - [Click Here](https://devlibrary.withgoogle.com/products/android/repos/amirisback-frogo-admob)
- Helper for activating admob
- Example Source Code For Call Method Show Admob
- Calling method on Inheritance Class
- Implement all Admob Version
- Jetpack Compose Function (Experimental)

## Note For Jitpack Build
- Red : Failed (So don't use that version / Using previous version)
- Green : Success / Pass (Use It)

## ScreenShot Apps
| Banner and Interstitial | RecyclerView with Banner | Rewarded Apps |
|:-----------------------:|:------------------------:|:-------------:|
|<img width="200px" height="360px" src="docs/image/ss_image_1.png"> | <img width="200px" height="360px" src="docs/image/ss_image_2.png"> | <img width="200px" height="360px" src="docs/image/ss_image_3.png"> |

## Version Release

    $version_release = 4.1.4

What's New??

    * Enhance Performance *
    * Refactoring Code *
    * Remove unused code *
    * Update documentation *
    * Update build.gradle *
    * Update sample code *
    * Update Android Gradle Plugin 7.0.2 *
    * Update Admob Library Version 20.5.0 *
    * Add Compose Implementation (Experimental) *
    * Add Java Sample *

## How To Use / Implement This Project
### Step 1. Add the JitPack repository to your build file

#### <Option 1> Groovy Gradle

    // Add it in your root build.gradle at the end of repositories:

    allprojects {
        repositories {
            ...
            maven { url 'https://jitpack.io' }
        }
    }

#### <Option 2> Kotlin DSL Gradle

```kotlin
// Add it in your root build.gradle.kts at the end of repositories:

allprojects {
    repositories {
        ...
        maven { url = uri("https://jitpack.io") }
    }
}
```

### Step 2. Add the dependency

#### <Option 1> Groovy

	dependencies {
	        // library google ads
            implementation 'com.google.android.gms:play-services-ads:${latest_version}'

            // library frogo-admob-helper
	        implementation 'com.github.amirisback:frogo-admob:4.1.4'
	}

#### <Option 2> Kotlin DSL

	dependencies {
	        // library google ads
            implementation("com.google.android.gms:play-services-ads:${latest_version}")

            // library frogo-admob-helper
	        implementation("com.github.amirisback:frogo-admob:4.1.4")
	}
	
### Step 3. Adding meta-data on AndroidManifest.xml
```xml
<manifest>
    <application>
        <!-- Sample AdMob App ID: ca-app-pub-3940256099942544~3347511713 -->
        <meta-data
            android:name="com.google.android.gms.ads.APPLICATION_ID"
            android:value="ca-app-pub-xxxxxxxxxxxxxxxx~yyyyyyyyyy"/>
    </application>
</manifest>
```
	
### Step 4. Setup Admob and Showing Ads

#### XML
<details>
  <summary>Click for detail!</summary>

#### Setup Ads
```kotlin
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
```

#### Showing Ads

```kotlin
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

        }

    }

}
```

</details>

#### Jetpack Compose

<details>
  <summary>Click for detail!</summary>

#### ComposeActivity

```kotlin

class ComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FrogoAdmobTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Column {
                        FrogoAdmobBannerView(
                            mAdUnitID = getString(R.string.admob_banner),
                            mAdSize = adsize_banner
                        )
                    }
                }
            }
        }
    }
}

```

</details>

#### Hybrid (Jetpack Compose + XML)

<details>
  <summary>Click for detail!</summary>

#### XML Layout

```xml

<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:ads="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".mvvm.main.MainActivity">

    <androidx.compose.ui.platform.ComposeView
        android:id="@+id/compose_view"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_above="@id/include_ads_view"/>

    <include
        android:id="@+id/include_ads_view"
        layout="@layout/ads_phone_tab_special_smart_banner" />

</RelativeLayout>

```

#### Kotlin Class

```kotlin

class HybridActivity : BaseActivity<ActivityHybridBinding>() {

    override fun setupViewBinding(): ActivityHybridBinding {
        return ActivityHybridBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {
            composeView.setContent {
                Greeting("FrogoAdmob")
            }

            setupShowAdsBanner(includeAdsView.adsPhoneTabSpecialSmartBanner)
        }

    }

    @Composable
    fun Greeting(name: String) {
        Text(text = "Hello $name!")
    }

}

```

</details>

## Java Sample Implementation
- Click this for detail [Full Code]()

<details>
  <summary>Click for detail!</summary>

### Setup Java BaseActivity
```java
public abstract class <Your BaseJavaActivity> extends FrogoAdmobActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupAdmob();
    }

    private void setupAdmob(){
        setPublisher();
        setBanner();
        setInterstitial();
        setRewarded();
        setRewardedInterstitial();
    }

    private void setPublisher() {
        // Your App ID
        setupAdsPublisher(getString(R.string.admob_publisher_id));
    }

    private void setBanner() {
        // Your Banner ID
        setupAdsBanner(getString(R.string.admob_banner));
    }

    private void setInterstitial() {
        // Your Interstitial ID
        setupAdsInterstitial(getString(R.string.admob_interstitial));
    }

    private void setRewarded() {
        // Your Rewarded ID
        setupAdsRewarded(getString(R.string.admob_rewarded));
    }

    private void setRewardedInterstitial() {
        // Your Rewarded ID
        setupAdsRewardedInterstitial(getString(R.string.admob_rewarded_interstitial));
    }

}
```

### Setup Your Activity

```java

public class MainJavaActivity extends BaseJavaActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());
        setupShowAdsBanner(binding.includeAdsView.adsPhoneTabSpecialSmartBanner);
        hideButton();
        setupButtonClick();
    }

    ...
    ...
    ...

    private void setupButtonClick() {

        binding.btnInterstitial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setupShowAdsInterstitial();
            }
        });

        binding.btnRewarded.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setupShowAdsRewarded(new IFrogoAdmob.UserEarned() {
                    @Override
                    public void onUserEarnedReward(@NonNull RewardItem rewardItem) {

                    }
                });
            }
        });

        binding.btnRewardedInterstitial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setupShowAdsRewardedInterstitial(new IFrogoAdmob.UserEarned() {
                    @Override
                    public void onUserEarnedReward(@NonNull RewardItem rewardItem) {

                    }
                });
            }
        });

    }

}

```

</details>

## Jetpack Compose Element

### Variable

```kotlin
val adsize_banner: AdSize = AdSize.BANNER
val adsize_full_banner: AdSize = AdSize.FULL_BANNER
val adsize_large_banner: AdSize = AdSize.LARGE_BANNER
val adsize_smart_banner: AdSize = AdSize.SMART_BANNER
val adsize_medium_rectangle: AdSize = AdSize.MEDIUM_RECTANGLE
val adsize_wide_skycraper: AdSize = AdSize.WIDE_SKYSCRAPER
```

### Function

```kotlin

@Composable
fun FrogoAdmobBannerView(
    mAdUnitID: String,
    mAdSize: AdSize,
    modifier: Modifier = Modifier
) {
    AndroidView(
        modifier = modifier.fillMaxWidth(),
        factory = { context ->
            FLog.d("FrogoAdmobBannerView")
            AdView(context).apply {
                adSize = mAdSize
                adUnitId = mAdUnitID
                loadAd(AdRequest.Builder().build())
            }
        }
    )
}

```


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
