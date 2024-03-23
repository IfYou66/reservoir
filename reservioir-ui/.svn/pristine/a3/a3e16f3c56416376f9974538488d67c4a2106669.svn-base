<template>
    <div class="has-logo" style="background-color: rgb(48, 65, 86);margin-top: 100px;">
        <!-- <logo v-if="showLogo" :collapse="isCollapse" /> -->
        <el-scrollbar :class="settings.sideTheme" wrap-class="scrollbar-wrapper">
            <el-menu
                :default-active="activeMenu"

                :background-color="settings.sideTheme === 'theme-dark' ? variables.menuBg : variables.menuLightBg"
                :text-color="settings.sideTheme === 'theme-dark' ? variables.menuText : 'rgba(0,0,0,.65)'"
                :unique-opened="false"
                :active-text-color="settings.theme"
                :collapse-transition="false"
                mode="vertical"
            >
                <sidebar-item
                    v-for="(route, index) in sidebarRouters"
                    :key="route.path  + index"
                    :item="route"
                    :base-path="route.path"
                />
            </el-menu>
        </el-scrollbar>
    </div>
</template>

<script>
import { mapGetters, mapState } from "vuex";
import Logo from "./Logo";
import SidebarItem from "./SidebarItem";
import variables from "@/assets/styles/variables.scss";

export default {
    components: { SidebarItem, Logo },
    computed: {
        ...mapState(["settings"]),
        ...mapGetters(["sidebarRouters", "sidebar"]),
        activeMenu() {
            const route = this.$route;
            const { meta, path } = route;
            // if set path, the sidebar will highlight the path you set
            if (meta.activeMenu) {
                return meta.activeMenu;
            }
            return path;
        },
        showLogo() {
            return this.$store.state.settings.sidebarLogo;
        },
        variables() {
            return variables;
        },
        isCollapse() {
            return !this.sidebar.opened;
        }
    }
};
</script>
<style>
	.tags-view-container .tags-view-wrapper .tags-view-item[data-v-fac8ca64] {
	    font-size: 18px !important;
	}
	.scroll-container[data-v-be6b7bae] .el-scrollbar__wrap {
	    height: 64px !important;
	}
</style>
