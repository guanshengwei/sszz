package com.shunaier.demo.common.constant;

/**
 * 分页常量
 * @author yuanjiangnan
 */
public class PageConstant {

	private PageConstant() {
    }

	/**
	 * 默认每页条数
	 */
    public static final Integer PAGE_SIZE = 10;
    
    /**
     * 默认页码
     */
    public static final Integer PAGE_NUM = 1;
    
    /**
     * 系统每页最大条数，每页条数超过最大值，默认使用此值
     */
    public static final Integer MAX_PAGE_SIZE = 100;
	
}
