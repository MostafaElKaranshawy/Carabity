<template>
<div class="scroll-container">
    <div class="scroll-content">
    <!-- Your scrollable content goes here -->
    <div v-for="item in items" :key="item.id" class="item">{{ item.text }}</div>
    </div>
</div>
</template>

<script>
export default {
data() {
    return {
    items: [
        { id: 1, text: 'Item 1' },
        { id: 2, text: 'Item 2' },
        { id: 3, text: 'Item 3' },
        // Add more items as needed
    ]
    };
}
};
</script>

<style>
.scroll-container {
height: 300px; /* Set the height of the scrollable container */
overflow-y: auto; /* Enable vertical scrolling */
border: 1px solid #ccc; /* Optional: Add a border for styling */
}

.scroll-content {
/* Optional: Add padding or margin for styling */
}

.item {
/* Optional: Style individual items within the scrollable content */
padding: 10px;
border-bottom: 1px solid #ddd;
}
</style>
