def time_travel_tree_traversal(splits):
    """

    :param splits: a list of tuples where each tuple is an (a, b, c) int triple
                   indicating that timeline a spawned timelines b and c
    :return: an integer indicating the largest distance between two timelines
    """

    adj_dict = {root: (left, right) for (root, left, right) in splits}
    node_id = 0

    return get_tree_diameter_and_height(adj_dict, node_id)[0]


def get_tree_diameter_and_height(adj_dict, node_id):
    if node_id in adj_dict:
        left_id, right_id = adj_dict[node_id]
        left_diameter, left_height = get_tree_diameter_and_height(adj_dict,
                                                                  left_id)
        right_diameter, right_height = get_tree_diameter_and_height(adj_dict,
                                                                    right_id)

        current_diameter = max(left_diameter, right_diameter,
                               left_height + right_height + 2)
        current_height = max(left_height, right_height) + 1

        return current_diameter, current_height

    else:
        return 0, 0


def parse_file_and_call_function():
    with open("TimeTravelTreeTraversalIN.txt", "r") as f:
        while True:
            start_test_case = f.readline()
            if not start_test_case:
                break
            num_lines = int(start_test_case)
            splits = []
            for i in xrange(num_lines):
                root, left, right = f.readline().split()
                splits.append((int(root), int(left), int(right)))
            print time_travel_tree_traversal(splits)


if __name__ == '__main__':
    parse_file_and_call_function()
