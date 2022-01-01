package com.example.viewpager2tablayout.ui.gallery

import android.graphics.Rect
import android.util.TypedValue
import android.view.View
import androidx.compose.ui.unit.dp
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GalleryGridDecoration(private var space: Float): RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        val position = parent.getChildAdapterPosition(view)
            .takeIf { it != RecyclerView.NO_POSITION } ?: run {
                return
        }

        val spaceToInt: Int = space.toInt()

        outRect.left = spaceToInt
        outRect.right = spaceToInt
        outRect.top = spaceToInt
        outRect.bottom = spaceToInt
    }
}


