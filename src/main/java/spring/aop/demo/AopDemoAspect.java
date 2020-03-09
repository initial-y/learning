package spring.aop.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @className: AopTestAspect
 * @author: yangxin
 * @date: 2020/3/9
 */
@Aspect
@Component
public class AopDemoAspect {

    /**
     * 定义一个切入点
     */
    @Pointcut("execution(public * spring.aop.demo..*.*(..))")
        public void checkParam(){
    }

    /**
     * 前置通知，在连接点之前执行的通知
     * @param joinPoint
     */
    @Before("checkParam()")
    public void doBefore(JoinPoint joinPoint){

    }


    /**
     * Before
     * 在方法被调用之前调用
     *
     *
     * After
     * 在方法完成后调用通知，无论方法是否执行成功
     *
     *
     * After-returning
     * 在方法成功执行之后调用通知
     *
     *
     * After-throwing
     * 在方法抛出异常后调用通知
     *
     *
     * Around
     * 通知了好、包含了被通知的方法，在被通知的方法调用之前后调用之后执行自定义的行为
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around(value = "checkParam()")
    public Object checkParam(ProceedingJoinPoint joinPoint) throws Throwable {
        Object object;
        String checkMsg = this.getCheckMsg(joinPoint);
        if (!StringUtils.isEmpty(checkMsg)) {
            throw new Exception(checkMsg);
        }
        object = joinPoint.proceed();
        return object;
    }

    public String getCheckMsg(ProceedingJoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        if (args == null || args.length == 0) {
            return null;
        }
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        MethodParamCheck methodParamCheck = method.getAnnotation(MethodParamCheck.class);
        if (Objects.nonNull(methodParamCheck)) {
            String[] fields = methodParamCheck.fileds();
            //获取方法参数名
            String[] paramNames = signature.getParameterNames();
            //获取方法参数类型
            Class<?>[] parameterTypes = method.getParameterTypes();

            for (String filed : fields) {

            }


        }


        return null;
    }

}
