package com.example.recyclerviewwithfeatures

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color.red
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator

abstract class SwipeGestures(context: Context) :
    ItemTouchHelper.SimpleCallback(
        ItemTouchHelper.UP or ItemTouchHelper.DOWN or ItemTouchHelper.START or ItemTouchHelper.END,
        ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
    ) {

    val deleteColor = ContextCompat.getColor(context, R.color.deleteColor)
    val archiveColor = ContextCompat.getColor(context, R.color.archiveColor)
    val deleteIcon = R.drawable.ic_baseline_delete_24
    val archiveIcon = R.drawable.ic_baseline_archive_24

    override fun onChildDraw(
        c: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float,
        actionState: Int,
        isCurrentlyActive: Boolean
    ) {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
        RecyclerViewSwipeDecorator.Builder(
            c,
            recyclerView,
            viewHolder,
            dX,
            dY,
            actionState,
            isCurrentlyActive
        )
            .addSwipeLeftBackgroundColor(deleteColor)
            .addSwipeLeftActionIcon(deleteIcon)
            .addSwipeRightBackgroundColor(archiveColor)
            .addSwipeRightActionIcon(archiveIcon)
            .create()
            .decorate();
    }
}