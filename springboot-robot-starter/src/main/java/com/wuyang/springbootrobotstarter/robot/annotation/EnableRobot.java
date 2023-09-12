package com.wuyang.springbootrobotstarter.robot.annotation;

import com.wuyang.springbootrobotstarter.robot.config.RobotAutoConfiguration;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.context.annotation.Import;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(RobotAutoConfiguration.class)
public @interface EnableRobot {

}
