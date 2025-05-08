<template>
  <div class="spinner" :style="{ width: size + 'px', height: size + 'px' }">
    <svg class="spinner-circle" viewBox="0 0 50 50">
      <circle
        class="path"
        cx="25"
        cy="25"
        r="20"
        fill="none"
        stroke-width="4"
      ></circle>
    </svg>
  </div>
</template>

<script setup lang="ts">
defineProps({
  size: {
    type: Number,
    default: 20
  }
})
</script>

<style scoped>
.spinner {
  display: inline-block;
  position: relative;
}

.spinner-circle {
  animation: rotate 2s linear infinite;
  transform-origin: center center;
  width: 100%;
  height: 100%;
  position: absolute;
  top: 0;
  left: 0;
}

.path {
  stroke: currentColor;
  stroke-linecap: round;
  animation: dash 1.5s ease-in-out infinite;
}

@keyframes rotate {
  100% {
    transform: rotate(360deg);
  }
}

@keyframes dash {
  0% {
    stroke-dasharray: 1, 150;
    stroke-dashoffset: 0;
  }
  50% {
    stroke-dasharray: 90, 150;
    stroke-dashoffset: -35;
  }
  100% {
    stroke-dasharray: 90, 150;
    stroke-dashoffset: -124;
  }
}
</style> 