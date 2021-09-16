package spring.ioc.imports;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author xin.yang
 * @className BackfielderImportSelector
 * @description
 * @date 2021/09/16
 */
public class BackfielderImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{Backfielder.class.getName(), BackfielderConfiguration.class.getName()};
    }
}
