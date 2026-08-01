package com.pluu.sample.remote.compose

object NetworkConfig {
    /**
     * Use localhost with adb reverse tcp:8080 tcp:8080.
     */
    private const val EMULATOR_HOST = "127.0.0.1"
    private const val PORT = 8080
    
    const val BASE_URL = "http://$EMULATOR_HOST:$PORT"
}
