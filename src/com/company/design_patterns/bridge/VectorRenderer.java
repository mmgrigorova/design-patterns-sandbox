package com.company.design_patterns.bridge;

class VectorRenderer implements Renderer{
    @Override
    public String whatToRenderAs(){
        return "lines";
    }
}

