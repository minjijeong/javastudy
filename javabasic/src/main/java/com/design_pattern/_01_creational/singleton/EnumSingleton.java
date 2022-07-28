package com.design_pattern._01_creational.singleton;

/**
 * Enum으로 싱글톤 구현시,
 * - 상속을 하지 못한다.
 * - 컴파일 시 미리 생성된다.
 * - 직렬화 & 역질렬화하여도 싱글톤을 파괴할 수 없다.
 */
public enum EnumSingleton {
    INSTANCE;
}
