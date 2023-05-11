import { defineStore } from "pinia";

export const useUserDetailsStore = defineStore("userDetails", {
  state: () => ({
    id: -1,
    email: null,
    nickname: null
  }),
  getters: {
    isAuthenticated: (state) => state.email == null ? false : true
  },
  actions: {
    logout() {
      this.id = -1;
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
