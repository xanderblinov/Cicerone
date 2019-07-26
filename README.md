# Cicerone
[![jCenter](https://api.bintray.com/packages/terrakok/terramaven/cicerone/images/download.svg)](https://bintray.com/terrakok/terramaven/cicerone/_latestVersion)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)  


## HH Mainainer
Alexander Blinov (@xanderblinov)

## Info about
[![Join the chat at https://gitter.im/terrakok/Cicerone](https://img.shields.io/badge/Gitter-Join%20Chat-brightred.svg?style=flat)](https://gitter.im/terrakok/Cicerone)  

[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-Cicerone-green.svg?style=true)](https://android-arsenal.com/details/1/4700)
[![Android Weekly](https://img.shields.io/badge/Android%20Weekly-250-green.svg)](http://androidweekly.net/issues/issue-250)
[![Android Weekly](https://img.shields.io/badge/Android%20Weekly-271-green.svg)](http://androidweekly.net/issues/issue-271)  

![](https://habrastorage.org/files/644/32e/9eb/64432e9eb3664723b3ee438449dab3b0.png)

Cicerone (a guide, one who conducts sightseers) is a lightweight library that makes the navigation in an Android app easy.  
It was designed to be used with the MVP pattern (try [Moxy](https://github.com/Arello-Mobile/Moxy)), but will work great with any architecture.

## Main advantages
+ is not tied to Fragments
+ not a framework
+ short navigation calls (no builders)
+ lifecycle-safe!
+ functionality is simple to extend
+ suitable for Unit Testing

## Additional features
+ opening several screens inside single call (for example: deeplink)
+ implementation of parallel navigation (Instagram like)
+ predefined navigator ready for Single-Activity apps
+ predefined navigator ready for setup transition animation

**See the sample application**

## How to add
Add the dependency in your build.gradle:
```groovy
dependencies {
    //Cicerone
    compile 'ru.terrakok.cicerone:cicerone:X.X.X'
}
```

Initialize the library (for example in your Application class):
```java
public class SampleApplication extends MvpApplication {
    public static SampleApplication INSTANCE;
    private Cicerone<Router> cicerone;

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;

        initCicerone();
    }

    private void initCicerone() {
        cicerone = Cicerone.create();
    }

    public NavigatorHolder getNavigatorHolder() {
        return cicerone.getNavigatorHolder();
    }

    public Router getRouter() {
        return cicerone.getRouter();
    }
}
```

## How it works?
<img src="https://github.com/terrakok/Cicerone/raw/develop/media/CiceroneDiagram.png" alt="drawing" width="800"/>

Presenter calls navigation method of Router.

```java
public class SamplePresenter extends Presenter<SampleView> {
    private Router router;

    public SamplePresenter() {
        router = SampleApplication.INSTANCE.getRouter();
    }

    public void onBackCommandClick() {
        router.exit();
    }

    public void onForwardCommandClick() {
        router.navigateTo(new SomeScreen());
    }
}
```

Router converts the navigation call to the set of Commands and sends them to CommandBuffer.

CommandBuffer checks whether there are _"active"_ Navigator:
- If yes, it passes the commands to the Navigator. Navigator will process them to achive the desired transition.
- If no, then CommandBuffer saves the commands in a queue, and will apply them as soon as new _"active"_ Navigator will appear.

```java
    void executeCommands(Command[] commands) {
        if (navigator != null) {
            navigator.applyCommands(commands);
        } else {
            pendingCommands.add(commands);
        }
    }
```

Navigator processes the navigation commands. Usually it is an anonymous class inside the Activity.
Activity provides Navigator to the CommandBuffer in _onResume_ and removes it in _onPause_.

**Attention**: Use _onResumeFragments()_ with FragmentActivity ([more info](https://developer.android.com/reference/android/support/v4/app/FragmentActivity.html#onResume()))

```java
@Override
protected void onResume() {
    super.onResume();
    SampleApplication.INSTANCE.getNavigatorHolder().setNavigator(navigator);
}

@Override
protected void onPause() {
    super.onPause();
    SampleApplication.INSTANCE.getNavigatorHolder().removeNavigator();
}

private Navigator navigator = new Navigator() {
    @Override
    public void applyCommands(Command[] commands) {
        //implement commands logic (apply command batch to navigation container)
    }
};
```

## Navigation commands
This commands set will fulfill the needs of the most applications. But if you need something special - just add it!
+ Forward - Opens new screen
![](https://github.com/terrakok/Cicerone/raw/develop/media/forward_img.png)
+ Back - Rolls back the last transition
![](https://github.com/terrakok/Cicerone/raw/develop/media/back_img.png)
+ BackTo - Rolls back to the needed screen in the screens chain
![](https://github.com/terrakok/Cicerone/raw/develop/media/backTo_img.png)
+ Replace - Replaces the current screen
![](https://github.com/terrakok/Cicerone/raw/develop/media/replace_img.png)

## Predefined navigators
The library provides predefined navigators for _Fragments_ and _Activity_.
To use, just provide it with the container and _FragmentManager_.
```java
private Navigator navigator = new SupportAppNavigator(this, R.id.container);
```
## Sample
To see how to add, initialize and use the library and predefined navigators check out the sample.
Or look at [GitFox (Android GitLab client)](https://gitlab.com/terrakok/gitlab-client)

![](https://github.com/terrakok/Cicerone/raw/develop/media/navigation.gif)
![](https://github.com/terrakok/Cicerone/raw/develop/media/insta_tabs.gif)
![](https://github.com/terrakok/Cicerone/raw/develop/media/animations.gif)

## External Participants
+ idea and code of original version - Konstantin Tskhovrebov (@terrakok)
+ architecture advice, documentation and publication of original version - Vasili Chyrvon (@Jeevuz)

## License
```
MIT License

Copyright (c) 2017 Konstantin Tskhovrebov (@terrakok)
                   and Vasili Chyrvon (@Jeevuz)

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
