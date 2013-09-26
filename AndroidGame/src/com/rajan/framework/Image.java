package com.rajan.framework;

import com.rajan.framework.Graphics.ImageFormat;

public interface Image {
	public int getWidth();
    public int getHeight();
    public ImageFormat getFormat();
    public void dispose();

}
