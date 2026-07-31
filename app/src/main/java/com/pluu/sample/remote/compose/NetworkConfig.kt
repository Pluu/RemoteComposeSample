package com.pluu.sample.remote.compose

object NetworkConfig {
    /**
     * Android Emulator's default gateway address to the host machine.
     */
    private const val EMULATOR_HOST = "10.0.2.2"
    private const val PORT = 8080
    
    const val BASE_URL = "http://$EMULATOR_HOST:$PORT"
}
