com.trindade.ware);
            String sc_id = yB.c(projectMap, "sc_id");
            if (yB.a(projectMap, "custom_icon")) {
                String iconPath = wq.e() + File.separator + sc_id;
                Uri iconUri;
                if (Build.VERSION.SDK_INT >= 24) {
                    iconUri = FileProvider.getUriForFile(activity.getApplicationContext(), activity.getPackageName() + ".provider", new File(iconPath, "icon.png"));
                } else {
                    iconUri = Uri.fromFile(new File(iconPath, "icon.png"));
                }
                viewHolder.imgIcon.setImageURI(iconUri);
            } else {
                viewHolder.imgIcon.setImageResource(R.drawable.default_icon);
            }

            viewHolder.appName.setText(yB.c(projectMap, "my_app_name"));
            viewHolder.projectName.setText(yB.c(projectMap, "my_ws_name"));
            viewHolder.pkgName.setText(yB.c(projectMap, "my_sc_pkg_name"));
            viewHolder.projectVersion.setText(String.format("%s(%s)", yB.c(projectMap, "sc_ver_name"), yB.c(projectMap, "sc_ver_code")));
            viewHolder.imgSelected.setVisibility(yB.a(projectMap, "selected") ? View.VISIBLE : View.GONE);
        }

        @Override
        @NonNull
        public ProjectAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ProjectAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.manage_library_popup_project_list_item, parent, false));
        }

        private class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            public final LinearLayout projectLayout;
            public final CircleImageView imgIcon;
            public final TextView projectName;
            public final TextView appName;
            public final TextView pkgName;
            public final TextView projectVersion;
            public final ImageView imgSelected;

            public ViewHolder(View itemView) {
                super(itemView);
                projectLayout = itemView.findViewById(R.id.project_layout);
                projectName = itemView.findViewById(R.id.project_name);
                imgIcon = itemView.findViewById(R.id.img_icon);
                appName = itemView.findViewById(R.id.app_name);
                pkgName = itemView.findViewById(R.id.package_name);
                projectVersion = itemView.findViewById(R.id.project_version);
                imgSelected = itemView.findViewById(R.id.img_selected);
                projectLayout.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
                if (!mB.a() && v.getId() == R.id.project_layout) {
                    selectedProjectIndex = getLayoutPosition();
                    selectProject(selectedProjectIndex);
                }
            }

            private void selectProject(int index) {
                if (projects.size() > 0) {
                    for (Map<String, Object> projectMap : projects) {
                        projectMap.put("selected", false);
                    }

                    projects.get(index).put("selected", true);
                    notifyDataSetChanged();
                }
            }
        }
    }
}
