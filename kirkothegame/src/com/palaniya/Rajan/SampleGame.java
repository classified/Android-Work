package com.palaniya.Rajan;

import com.Rajan.framework.*;
import com.Rajan.framework.implementation.AndroidGame;

public class SampleGame extends AndroidGame {
   
	@Override
    public LoadingScreen getInitScreen() {
        return new LoadingScreen(this);
    }
   
}
