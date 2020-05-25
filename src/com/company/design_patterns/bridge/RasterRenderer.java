package com.company.design_patterns.bridge;

public class RasterRenderer implements Renderer{
    @Override
    public String whatToRenderAs(){
        return "pixels";
    }
}
