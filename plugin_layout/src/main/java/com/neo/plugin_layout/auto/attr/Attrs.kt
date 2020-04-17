package com.neo.plugin_layout.auto.attr

/**
 * Created by zhy on 15/12/5.
 *
 *
 * 与attrs.xml中数值对应
 */
interface Attrs {
    companion object {
        const val WIDTH = 1
        const val HEIGHT = WIDTH shl 1
        const val TEXTSIZE = HEIGHT shl 1
        const val PADDING = TEXTSIZE shl 1
        const val MARGIN = PADDING shl 1
        const val MARGIN_LEFT = MARGIN shl 1
        const val MARGIN_TOP = MARGIN_LEFT shl 1
        const val MARGIN_RIGHT = MARGIN_TOP shl 1
        const val MARGIN_BOTTOM = MARGIN_RIGHT shl 1
        const val PADDING_LEFT = MARGIN_BOTTOM shl 1
        const val PADDING_TOP = PADDING_LEFT shl 1
        const val PADDING_RIGHT = PADDING_TOP shl 1
        const val PADDING_BOTTOM = PADDING_RIGHT shl 1
        const val MIN_WIDTH = PADDING_BOTTOM shl 1
        const val MAX_WIDTH = MIN_WIDTH shl 1
        const val MIN_HEIGHT = MAX_WIDTH shl 1
        const val MAX_HEIGHT = MIN_HEIGHT shl 1
    }
}