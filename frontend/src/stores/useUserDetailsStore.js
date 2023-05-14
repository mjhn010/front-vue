import { defineStore } from "pinia";

export const useUserDetailsStore = defineStore("userDetails", {
  state: () => ({
    id: null,
    email: null,
    nickname: null
  }),
  getters: {
    isAuthenticated: (state) => state.email == null ? false : true
  },
  actions: {
    logout() {
      this.id = null;
      this.email = null;
      this.nickname = null;
    },
    hasRole() {
      let result = this.email == null ? false : true;
      return result;
    }
  },
  persist: {
    enabled: true
  }
});
