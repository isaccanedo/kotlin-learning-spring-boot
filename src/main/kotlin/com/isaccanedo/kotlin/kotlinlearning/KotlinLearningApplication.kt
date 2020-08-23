package com.techprimers.kotlin.kotlinlearning

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class KotlinLearningApplication

fun main(args: Array<String>) {
    SpringApplication.run(KotlinLearningApplication::class.java, *args)
}
