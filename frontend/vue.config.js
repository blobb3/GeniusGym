module.exports = {
    pluginOptions: {
      vite: {
        vueCompilerOptions: {
          compilerOptions: {
            isCustomElement: (tag) => tag.startsWith('ion-')
          }
        }
      }
    }
  };